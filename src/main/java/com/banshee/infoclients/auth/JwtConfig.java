package com.banshee.infoclients.auth;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JwtConfig {
    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
        "MIIEpAIBAAKCAQEA86keDJiWErFFFsT5KNW5ey3V7FZfeTWYePzucqJKsFJwkayE\n" +
        "WdyLsC41EIa+HoUthtiP0J3uYYMqhnPs9U8mYS0Xmfsx4+zz2dORpqzLQnbYrxB8\n" +
        "h4OLPHkkrkK7MHNqDuxSGxW+ZyhncB2RxaHwwt+S6XjE1ew4eC/foXzw7DslQRNO\n" +
        "eQzgQX4YDRXy+hw0nTuJe7QAkEIoxWf7SlaIS/ZoEJ0+ONmMCGPfVea/46GifGfB\n" +
        "bvQD4LZfkrYVrI8qp0pOJplWyYi5zkxJQ6pZ2g8OcBve95I0sZri0df2/RM/1PSC\n" +
        "lDBHhxZZX+RWonrIpvnWO8gO9QmkSJ/Jx/K6BQIDAQABAoIBADj8AUIS4W4ntS+5\n" +
        "C0hoi4NqWdB29scjKLCK/r0ihXMtJJR9E0rs0GJ4vAJMcOQ0Y0xZE3FHrjtx8J0X\n" +
        "OYC5bRFm+VEStT1H6lO0Likb2kGGB/ERWv5aXlLbRh/XDW4sX85zqFQbRrdbdK18\n" +
        "zN26nNMGdJZTnz0kjKRXFebvkGy+h4pjd+qWgKmlKenJgWjTDwRssKubgOWrdZCS\n" +
        "zouP/23rDaJhFNFQWDIunL8T59MKAaCfEzd80BeN7F5KD64US5T1LrSzntsy8/Qv\n" +
        "6J21UM8vYY/sNQxbFu68IdFx6lWnVL0Tm6Y16GHmZBo5WL3ZCxleFRRu4obLspiU\n" +
        "Awl2pfUCgYEA+xf2ZQFVPJLCYiUs7a3j9SrLcFOvEw7pTcHGpmT3QBCzAaZTos2F\n" +
        "t26zaRJejRUoL2VfUWsQPwV+SOcLQFi7OAasMXjDq5R2eGU97RSQflK0Z1fw8yu+\n" +
        "qz0jFKYTwjB2kUL0DdeqL9ppWoxnFx7f1rJ1AA4Gh0LFmnsna/IwdB8CgYEA+Gv5\n" +
        "HQLCUyg2u3O0HtSWliRTLz+zWBTTHUGGDeuxgkp86hdDjrf9TYBWiWBu6ZVfCB3J\n" +
        "J4ABgawq8eebCIBw23Cm3qoWe2hZ8LfPmF6jOjUGKKJil1a0qnIHQRu4QDsjbnnP\n" +
        "ie9baFWXqo0uQybo4VADLxgxjgPncxL+JMmwLVsCgYBcVb+B/S9/Cuj4dntDHAMM\n" +
        "ESSmtd9XvtAEjBGk9tQFdx6cqLFw2OsnPUo0hVDHyNPyOfEHW7upsTdzT6NPklGm\n" +
        "lK2Vs7cgzYOTWoefO0S3b2pv5mLwyVFgXycbXMc/TdsMJ/bfcENhPYwohCEU24Gs\n" +
        "zgtAbefwrZlE6azhgTpYOQKBgQDv38KR4sIlbeU7qAO66Wfm3nh8XTQdzy3zR/vb\n" +
        "oUSsHKT1nTUcsEik91GYIUe3wQYcXjaIL7BEuCxXnV40HWHcYrCevPose5ytNa/8\n" +
        "3xUZ9W1W+0XcAFs/Yg/jLJMDYpdZ68Ec3cUTv+JNSznqmb2xIoOQi/n9uYNZuHMy\n" +
        "rpWxlQKBgQDZOoLXzoxNQIvu4Bve5VfsS54K3fPL7GaPHfo1RFS0JV16SvKB20oy\n" +
        "qMUi9iPFl6Sb8x/gsVuIwTTW30xceGqeZHVXPntjdYbQsJElHAT0X4bcbuA4TSI8\n" +
        "lXqgawZycBmN+Y24D4RruLbOd/XTXGEw43MD60FN3XkLAPmS0aMiKA==\n" +
        "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA86keDJiWErFFFsT5KNW5\n" +
        "ey3V7FZfeTWYePzucqJKsFJwkayEWdyLsC41EIa+HoUthtiP0J3uYYMqhnPs9U8m\n" +
        "YS0Xmfsx4+zz2dORpqzLQnbYrxB8h4OLPHkkrkK7MHNqDuxSGxW+ZyhncB2RxaHw\n" +
        "wt+S6XjE1ew4eC/foXzw7DslQRNOeQzgQX4YDRXy+hw0nTuJe7QAkEIoxWf7SlaI\n" +
        "S/ZoEJ0+ONmMCGPfVea/46GifGfBbvQD4LZfkrYVrI8qp0pOJplWyYi5zkxJQ6pZ\n" +
        "2g8OcBve95I0sZri0df2/RM/1PSClDBHhxZZX+RWonrIpvnWO8gO9QmkSJ/Jx/K6\n" +
        "BQIDAQAB\n" +
        "-----END PUBLIC KEY-----";

}

