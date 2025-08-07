CREATE TABLE IF NOT EXISTS dpd_consents (
    user_id UUID,
    ts DateTime64(3),
    consent_type Enum8('aadhaar','upi'),
    ip IPv4,
    region LowCardinality(String)
) ENGINE = MergeTree
  PARTITION BY toYYYYMM(ts)
  ORDER BY (user_id, ts);