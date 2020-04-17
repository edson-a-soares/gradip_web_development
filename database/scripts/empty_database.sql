DO $$
    DECLARE
        tablenames TEXT;

    BEGIN
        tablenames := string_agg('"' || tablename || '"', ', ')
                      FROM pg_tables WHERE schemaname = 'public';
        EXECUTE 'TRUNCATE TABLE ' || tablenames;
    END;
$$;
