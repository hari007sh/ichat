CREATE KEYSPACE messenger WITH replication = {'class': 'NetworkTopologyStrategy', 'dc1': 3};
CREATE TABLE messages (
  user_id uuid,
  day date,
  ts timeuuid,
  cipher blob,
  PRIMARY KEY ((user_id, day), ts)
) WITH CLUSTERING ORDER BY (ts DESC);