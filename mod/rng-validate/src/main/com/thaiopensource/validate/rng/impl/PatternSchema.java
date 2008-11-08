package com.thaiopensource.validate.rng.impl;

import com.thaiopensource.relaxng.impl.Pattern;
import com.thaiopensource.relaxng.impl.SchemaPatternBuilder;
import com.thaiopensource.relaxng.impl.ValidatorPatternBuilder;
import com.thaiopensource.util.PropertyMap;
import com.thaiopensource.validate.AbstractSchema;
import com.thaiopensource.validate.ValidateProperty;
import com.thaiopensource.validate.Validator;
import org.xml.sax.ErrorHandler;

public class PatternSchema extends AbstractSchema {
  private final SchemaPatternBuilder spb;
  private final Pattern start;

  public PatternSchema(SchemaPatternBuilder spb, Pattern start, PropertyMap properties) {
    super(properties);
    this.spb = spb;
    this.start = start;
  }

  public Validator createValidator(PropertyMap properties) {
    ErrorHandler eh = ValidateProperty.ERROR_HANDLER.get(properties);
    return new RngValidator(start, new ValidatorPatternBuilder(spb), eh);
  }
}