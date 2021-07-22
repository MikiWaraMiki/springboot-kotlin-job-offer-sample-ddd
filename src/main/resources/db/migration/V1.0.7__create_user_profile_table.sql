CREATE TABLE IF NOT EXISTS user_profiles (
    user_uuid CHAR(26) NOT NULL,
    profile_text TEXT NOT NULL,
    created_at TIMESTAMP  NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_profile_user_uuid
    FOREIGN KEY (user_uuid)
    REFERENCES users (uuid)
    ON DELETE RESTRICT
);