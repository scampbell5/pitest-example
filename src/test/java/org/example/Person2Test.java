package org.example;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.example.Person;
import org.junit.Test;

public class Person2Test {

    @Test
    public void test_gettersAndSetters() {

        PojoClass pojoClass = PojoClassFactory
                .getPojoClass(Person2.class);

        Validator validator = ValidatorBuilder
                .create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new EqualsAndHashCodeMatchRule())
                .with(new GetterTester())
                .with(new SetterTester())
                .build();

        validator.validate(pojoClass);
    }
}