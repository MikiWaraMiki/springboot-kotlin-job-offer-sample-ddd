CREATE TABLE IF NOT EXISTS user_connection_informations (
    id bigint NOT NULL PRIMARY KEY,
    user_uuid CHAR(26) NOT NULL,
    connection_type VARCHAR(256) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_connection_informations_user_uuid
    FOREIGN KEY (user_uuid)
    REFERENCES users (uuid)
    ON DELETE RESTRICT
) ENGINE= InnoDB;
ALTER TABLE user_connection_informations ADD UNIQUE uniq_user_connection_informations_uuid_and_connection_type(user_uuid, connection_type);