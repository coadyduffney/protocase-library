package com.protocase.protocaselibrary.fundamental;

import java.util.UUID;

/**
 * @author Coady Duffney
 */
public class TestUser extends User {
    public TestUser() {
        super(
                UUID.randomUUID().toString(),
                "Coady", "Duffney",
                "cduffney@protocase.com"
        );
    }
}
