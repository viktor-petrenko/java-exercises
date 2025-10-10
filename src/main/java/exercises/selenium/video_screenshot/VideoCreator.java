package exercises.selenium.video_screenshot;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoCreator {

  private static final int FRAME_RATE = 25;
  private static final Dimension SCREEN_BOUNDS = Toolkit.getDefaultToolkit().getScreenSize();

  private File outputFile;
  private final AtomicBoolean pleaseStop = new AtomicBoolean(false);
  private volatile boolean stoppedCreation = true;

  public VideoCreator() { }

  public VideoCreator(File outputFile) {
    this.outputFile = outputFile;
  }

  public void createVideoFromScreens() {
    if (outputFile == null) {
      throw new IllegalStateException("Output video file cannot be null");
    }

    FFmpegFrameRecorder recorder = null;
    Java2DFrameConverter converter = new Java2DFrameConverter();

    try {
      stoppedCreation = false;

      recorder = new FFmpegFrameRecorder(outputFile.getAbsolutePath(),
              SCREEN_BOUNDS.width, SCREEN_BOUNDS.height);

      // Container/codec settings
      recorder.setFormat("mp4");
      recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
      recorder.setFrameRate(FRAME_RATE);
      recorder.setVideoBitrate(3_000_000);     // ~3 Mbps
      recorder.setPixelFormat(org.bytedeco.ffmpeg.global.avutil.AV_PIX_FMT_YUV420P);

      recorder.start();

      final long frameIntervalMs = Math.round(1000.0 / FRAME_RATE);
      Robot robot = new Robot();
      Rectangle capture = new Rectangle(SCREEN_BOUNDS);

      while (!pleaseStop.get()) {
        BufferedImage screen = robot.createScreenCapture(capture);
        // Ensure 3BYTE_BGR for best compatibility before converting to Frame
        if (screen.getType() != BufferedImage.TYPE_3BYTE_BGR) {
          BufferedImage bgr = new BufferedImage(screen.getWidth(), screen.getHeight(),
                  BufferedImage.TYPE_3BYTE_BGR);
          Graphics2D g = bgr.createGraphics();
          g.drawImage(screen, 0, 0, null);
          g.dispose();
          screen = bgr;
        }
        Frame frame = converter.convert(screen);
        recorder.record(frame);

        try {
          Thread.sleep(frameIntervalMs);
        } catch (InterruptedException ignored) {
          Thread.currentThread().interrupt();
          break;
        }
      }

    } catch (Exception e) {
      throw new RuntimeException("Failed to record screen video", e);
    } finally {
      stoppedCreation = true;
      try {
        if (recorder != null) {
          recorder.stop();
          recorder.release();
        }
      } catch (Exception ignored) { }
      converter.close();
    }
  }

  // --- getters/setters & control ---

  public File getOutputFile() { return outputFile; }
  public void setOutputFile(File outputFile) { this.outputFile = outputFile; }

  /** Signal the recording loop to stop gracefully */
  public void setPleaseStop(boolean value) { this.pleaseStop.set(value); }
  public boolean getPleaseStop() { return pleaseStop.get(); }

  public boolean isStoppedCreation() { return stoppedCreation; }
}