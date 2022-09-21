create schema if not exists test;
create table if not exists test.samples (
  id uuid primary key,
  name text
);
create table if not exists test.sample_values (
  id uuid primary key,
  sample_id uuid references test.samples(id)
    deferrable initially deferred,
  value int
);