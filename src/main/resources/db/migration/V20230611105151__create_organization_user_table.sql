CREATE TABLE org_user
(
    id      BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    org_id  BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_org_user_org FOREIGN KEY (org_id) REFERENCES organizations (id) ON DELETE CASCADE,
    CONSTRAINT fk_org_user_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    UNIQUE (org_id, user_id)
);