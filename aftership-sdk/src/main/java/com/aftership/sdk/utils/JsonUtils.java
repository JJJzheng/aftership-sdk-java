package com.aftership.sdk.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Optional;

/** Json's assistant method. */
public final class JsonUtils {

  /**
   * Creating a Gson object
   *
   * @return Gson object
   */
  public static Gson create() {
    return create(false);
  }

  /**
   * Creating a Gson object
   *
   * @param pretty Does it print in a nice format
   * @return Gson object
   */
  public static Gson create(boolean pretty) {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Date.class, new GsonDateDeSerializer());
    if (pretty) {
      builder.setPrettyPrinting();
    }
    builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return builder.create();
  }

  private static class GsonDateDeSerializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
      String dateString = json.getAsJsonPrimitive().getAsString();
      return parseDate(dateString);
    }

    private Date parseDate(String dateString) {
      if (StrUtils.isBlank(dateString)) {
        return null;
      }

      String[] formats =
          new String[] {
            DateUtils.FORMAT_WITH_T,
            DateUtils.FORMAT_WITHOUT_T,
            DateUtils.FORMAT_WITH_Z,
            DateUtils.FORMAT_WITH_X
          };
      for (String item : formats) {
        Optional<Date> optionalDate = DateUtils.parse(item, dateString);
        if (optionalDate.isPresent()) {
          return optionalDate.get();
        }
      }

      return null;
    }

  }
}