DROP TABLE expenses;

CREATE TABLE IF NOT EXISTS expenses (
      expense_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
      account_id UUID NOT NULL,
      category_id UUID NOT NULL,
      expense_type expense_type NOT NULL,
      description VARCHAR(255) NOT NULL,
      amount NUMERIC(15, 2) NOT NULL CHECK (amount > 0),
      expense_date DATE NOT NULL,
      created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
      FOREIGN KEY (account_id) REFERENCES accounts(account_id) ON DELETE CASCADE,
      FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE
);