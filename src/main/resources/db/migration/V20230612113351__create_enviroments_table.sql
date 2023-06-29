CREATE TABLE environments
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR(255)                        NOT NULL,
    app_id     BIGINT                              NOT NULL,
    key        VARCHAR(255)                        NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (app_id) REFERENCES apps (id) ON DELETE CASCADE,
    UNIQUE (name, app_id),
    UNIQUE (key)
);