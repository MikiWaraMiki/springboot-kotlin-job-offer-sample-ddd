-- create users
CREATE TABLE IF NOT EXISTS users (
    uuid BINARY(16) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP ,
    PRIMARY KEY (uuid)
) ENGINE= InnoDB;
ALTER TABLE users ADD INDEX idx_users_created_at(created_at);
