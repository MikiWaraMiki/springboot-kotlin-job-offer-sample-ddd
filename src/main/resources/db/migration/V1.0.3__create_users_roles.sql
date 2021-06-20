CREATE TABLE IF NOT EXISTS users_roles (
    user_uuid BINARY(16) NOT NULL,
    role_id bigint NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_users_roles_user_uuid
    FOREIGN KEY (user_uuid)
    REFERENCES users (uuid)
    ON DELETE RESTRICT,

    CONSTRAINT fk_users_roles_role_id
    FOREIGN KEY (role_id)
    REFERENCES roles (id)
    ON DELETE RESTRICT
);

ALTER TABLE users_roles ADD UNIQUE uniq_users_roles_user_uuid_role_id(user_uuid, role_id);