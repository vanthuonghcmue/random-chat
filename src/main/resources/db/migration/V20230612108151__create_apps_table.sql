CREATE TABLE apps
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR(255)                        NOT NULL,
    org        BIGINT                              NOT NULL,
    owner      BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (org) REFERENCES organizations (id) ON DELETE CASCADE,
    FOREIGN KEY (owner) REFERENCES users (id) ON DELETE SET NULL
);
