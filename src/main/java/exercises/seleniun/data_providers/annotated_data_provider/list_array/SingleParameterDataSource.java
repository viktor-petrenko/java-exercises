package exercises.seleniun.data_providers.annotated_data_provider.list_array;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SingleParameterDataSource {
  Class clazz() default void.class;
  String value();
}
