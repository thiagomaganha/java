ALTER TABLE accounts ADD COLUMN IF NOT EXISTS account_name varchar(255);

ALTER TABLE accounts ADD UNIQUE(user_id, account_name);