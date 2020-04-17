CREATE TABLE IF NOT EXISTS changelog (
  change_number SERIAL        NOT NULL,
  complete_dt   TIMESTAMP     NOT NULL,
  applied_by    VARCHAR(100)  NOT NULL,
  description   VARCHAR(500)  NOT NULL
);

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'pk_changelog') THEN
        ALTER TABLE changelog
            ADD CONSTRAINT pk_changelog PRIMARY KEY (change_number);
    END IF;
END;
$$;