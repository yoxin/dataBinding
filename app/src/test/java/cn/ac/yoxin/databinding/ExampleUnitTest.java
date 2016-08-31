package cn.ac.yoxin.databinding;

import org.junit.Test;

import cn.ac.yoxin.databinding.api.BusModel;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getBus() throws Exception {
        System.out.print(BusModel.getInstance().getBuses("广州").toString());
    }
}