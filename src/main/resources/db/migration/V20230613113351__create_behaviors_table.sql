CREATE TABLE behaviors
(
    id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    env_id           BIGINT                              NOT NULL,
    version_operator VARCHAR(255)                        NOT NULL,
    version_number   VARCHAR(255)                        NOT NULL,
    time             TIMESTAMP,
    time_operator    VARCHAR(255),
    numerical_order  INTEGER                             NOT NULL,
    language         VARCHAR(255),
    data             VARCHAR(255)                        NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (env_id) REFERENCES environments (id) ON UPDATE CASCADE ON DELETE CASCADE
);