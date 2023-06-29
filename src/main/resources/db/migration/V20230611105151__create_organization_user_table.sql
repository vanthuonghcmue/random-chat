CREATE TABLE org_user
(
    id      BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    org_id  BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    role_id BIGINT,
    CONSTRAINT fk_org_user_org FOREIGN KEY (org_id) REFERENCES organizations (id) ON DELETE CASCADE,
    CONSTRAINT fk_org_user_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_org_user_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE SET NULL,
    UNIQUE (org_id, user_id)
);