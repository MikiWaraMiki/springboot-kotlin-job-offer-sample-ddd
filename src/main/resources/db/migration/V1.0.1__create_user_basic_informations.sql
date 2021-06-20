-- create user basic info
CREATE TABLE IF NOT EXISTS user_basic_informations (
    id bigint NOT NULL PRIMARY KEY,
    user_uuid BINARY(16) NOT NULL,
    email VARCHAR(256) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_basic_informations_user_uuid
    FOREIGN KEY (user_uuid)
    REFERENCES users (uuid)
    ON DELETE RESTRICT
) ENGINE= InnoDB;
ALTER TABLE user_basic_informations ADD UNIQUE uniq_user_basic_informations_email(email);