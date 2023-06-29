CREATE TABLE users
(
    id                BIGINT                  NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name              VARCHAR(255)            NOT NULL,
    email             VARCHAR(255)            NOT NULL,
    email_verified_at TIMESTAMP DEFAULT NULL,
    password          VARCHAR(255)            NOT NULL,
    remember_token    VARCHAR(255),
    created_at        TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at        TIMESTAMP DEFAULT NOW() NOT NULL

);
