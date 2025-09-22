package com.cb.selenium_cb;

import com.cb.selenium_cb.base.TestBase;
import org.junit.jupiter.api.Test;

public class CbTest extends TestBase {

    @Test
    public void verifyTitle() {
        System.out.println("✅ Page Title is: " + driver.getTitle());
    }
}
