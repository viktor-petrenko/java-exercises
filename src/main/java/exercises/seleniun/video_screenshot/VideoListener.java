package exercises.seleniun.video_screenshot;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;

public class VideoListener implements IInvokedMethodListener {

  private VideoCreator screencaster;
  private Thread videoThread;

  @Override
  public void beforeInvocation(IInvokedMethod m, ITestResult res) {
    if (m.isTestMethod()) {
      File videoFile = new File(
          res.getTestContext().getOutputDirectory(),
          m.getTestMethod().getMethodName() + ".flv");
      screencaster = new VideoCreator(videoFile);
      videoThread = new Thread(new Runnable() {
        @Override
        public void run() {
          screencaster.createVideoFromScreens();
        }
      });
      videoThread.start();
    }
  }

  @Override
  public void afterInvocation(IInvokedMethod m, ITestResult res) {
    if (m.isTestMethod() && screencaster !=  null) {
      try {
        Thread.sleep(2000);
        screencaster.setPleaseStop(true);
        while (! screencaster.isStoppedCreation()) {
          Thread.sleep(500);
        }
        videoThread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      screencaster = null;
      videoThread = null;
    }
  }
}
