CREATE TABLE IF NOT EXISTS user_experience_jobs (
    user_uuid CHAR(26) NOT NULL,
    job_id bigint NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,

    CONSTRAINT fk_user_experience_jobs_user_uuid
    FOREIGN KEY (user_uuid)
    REFERENCES users (uuid)
    ON DELETE RESTRICT ,

    CONSTRAINT fk_user_experience_jobs_job_id
    FOREIGN KEY (job_id)
    REFERENCES jobs (id)
    ON DELETE RESTRICT
);

ALTER TABLE user_experience_jobs ADD UNIQUE uniq_user_experience_jobs(user_uuid, job_id);