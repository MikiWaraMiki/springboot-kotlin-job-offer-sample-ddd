-- user AUTH Basic Info
CREATE TABLE IF NOT EXISTS user_auth_info (
    uuid BINARY(16) NOT NULL,
    email varchar(256) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP ,
    PRIMARY KEY (uuid)
) ENGINE= InnoDB;
ALTER TABLE user_auth_info ADD INDEX idx_user_auth_info_email(email);


-- user connection info
CREATE TABLE IF NOT EXISTS user_connection_info (
    uuid BINARY(16) NOT NULL PRIMARY KEY,
    connection_type varchar(256) NOT NULL,
    user_uuid BINARY(16) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_uuid
    FOREIGN KEY (user_uuid)
    REFERENCES user_auth_info (uuid)
    ON DELETE RESTRICT
) ENGINE = InnoDB;
ALTER TABLE user_connection_info ADD UNIQUE(user_uuid, connection_type);
