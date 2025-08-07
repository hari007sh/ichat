CREATE TABLE users (
  id uuid PRIMARY KEY,
  phone varchar(15) UNIQUE,
  e2ee_pub bytea,
  created_at timestamptz DEFAULT now()
);

CREATE TABLE upi_mandates (
  id uuid PRIMARY KEY,
  user_id uuid REFERENCES users(id),
  pa varchar(50),
  amount_kopeks int,
  status varchar(10) CHECK (status IN ('ACTIVE','REVOKED'))
);