-----------------------------------------------------------------
-- Actors
-----------------------------------------------------------------
INSERT INTO
    actors (actor_id, actor_name)
VALUES
    ('de1621d42ec344a48a498c13c6d7ba23', 'Keanu Reeves'),
    ('e183f032045b495690336935c8cf8887', 'Al Pacino'),
    ('5b36c7c685f14edd-b8b349c8f3caaba5', 'Robert Downey Jr'),
    ('ca1ac92ff56b45bcac0219211d36eb4a', 'Denzel Washington'),
    ('7168a06956dc4b8388d66f30c03c1632', 'Angelina Jolie'),
    ('450f3260d7fc4455b831860e03629e88', 'Charlize Theron');

-----------------------------------------------------------------
-- Film Crew People
-----------------------------------------------------------------
INSERT INTO
    film_crew_people (person_id, person_name)
VALUES
    ('8636bf7ffe8c48b78b8116c8fa092c4d', 'Anthony Russo'),
    ('88a7bde4a4284d6cba2d203ab8113818', 'Joe Russo'),
    ('5197bb6502054587add8b731d91ec49f', 'Stan Lee'),
    ('aaa153028dd645e8b44d24c3d55550b2', 'Jack Kirby'),
    ('fd1a6d932cbe44b68dd7d49ac8f8c5b8', 'Jim Starlin'),
    ('001f4a64c7b448e69cbae27b3a4a36a6', 'Ruben Fleischer'),
    ('32ce98f94fc1469dac2e-582a7d8c1af4', 'Todd McFarlane'),
    ('ea8c203e31144234-9987c35eb17c121c', 'David Michelinie'),
    ('14c1fbfe18944c3eb86be1e89ab337c2', 'Joe Johnston'),
    ('46ff1a27d1a743698cd700b80c173055', 'Jon Favreau'),
    ('e3c8b36a12234ea7b6c3c391c9564960', 'Kevin Feige'),
    ('984cb790feee465ab79e673cc2542236', 'Taylor Hackford'),
    ('4eeac1072e664bd8a127f9f1631f680f', 'Andrew Neiderman'),
    ('7947646a4ad14677ba84-40d98b20791a', 'Jonathan Lemkin'),
    ('5b236a10e1a34a4bbf9ffbe9e648acbd', 'Phillip Noyce'),
    ('af877aca802b4e21b330-fde905b780cb', 'Tony Gilroy');

-----------------------------------------------------------------
-- Film Crew Roles
-----------------------------------------------------------------
INSERT INTO
    film_crew_roles (role_id, role_name, role_description)
VALUES
    ('3785a4aebdd541f191f89a2f651f9677', 'Screenwriter', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('7e290cc71b9c46b49bbcf4f9f66be199', 'Director', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('12252726-bd0246a6857714a4ab2c5470', 'Camera Operator', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('951dc6167aea44968a8c802d8bd23969', 'Costume Designer', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('5491b9e2ba0e4461ab12f890ea2c558c', 'Production Manager', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('8b3c67c99b1a4310a335255640e8295b', 'Producer', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('ac8092ee-22bb422da70535ca657cf84f', 'Recurring', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

-----------------------------------------------------------------
-- Acting Roles
-----------------------------------------------------------------
INSERT INTO
    acting_roles (role_id, role_name, role_description)
VALUES
    ('d07dfaea806c46c49cabf4ae7edfb58b', 'Star', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('b950266984a94841b649-0f6af78e2bbf', 'Supporting Actor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('a622877f-9d734136b535fdebcb596f93', 'Guest Star', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('732ddd48-d4d54351ab8e67032b61fad6', 'Cameo', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('e090acd95b9a4de399a5e2bd8fc99926', 'Background Actor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

-----------------------------------------------------------------
-- Movies
-----------------------------------------------------------------
INSERT INTO
    movies (movie_id, title, plot_synopsis, release_year)
VALUES
    ('41dad570130f4397af9cbd9a525c129a', 'Iron Man', 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.', 2008),
    ('5dd4cf43e7f04eeea35d3b3727b92ee1', 'Infinity War', 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.', 2018),
    ('be49c6de0761401bad9dbae17c0f8327', 'Venom', 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.', 2018),
    ('9bec3337dea24f768e3e8240645f7b1f', 'The Devils Advocate', 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.', 1997),
    ('8fc13ddddc6e4b0490f3ab77ef73e9f2', 'The Bone Collector', 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.', 1999);

-----------------------------------------------------------------
-- Cast Members
-----------------------------------------------------------------
INSERT INTO
    cast_members (actor_id, movie_id, role_id)
VALUES
    ('5b36c7c685f14edd-b8b349c8f3caaba5', '41dad570130f4397af9cbd9a525c129a', 'd07dfaea806c46c49cabf4ae7edfb58b'),
    ('de1621d42ec344a48a498c13c6d7ba23', '9bec3337dea24f768e3e8240645f7b1f', 'd07dfaea806c46c49cabf4ae7edfb58b'),
    ('de1621d42ec344a48a498c13c6d7ba23', '9bec3337dea24f768e3e8240645f7b1f', 'd07dfaea806c46c49cabf4ae7edfb58b'),
    ('7168a06956dc4b8388d66f30c03c1632', '8fc13ddddc6e4b0490f3ab77ef73e9f2', 'd07dfaea806c46c49cabf4ae7edfb58b');

-----------------------------------------------------------------
-- Film Crew Members
-----------------------------------------------------------------
INSERT INTO
    film_crew_members (person_id, movie_id, role_id)
VALUES
    ('5b236a10e1a34a4bbf9ffbe9e648acbd', '8fc13ddddc6e4b0490f3ab77ef73e9f2', '7e290cc71b9c46b49bbcf4f9f66be199'),
    ('4eeac1072e664bd8a127f9f1631f680f', '9bec3337dea24f768e3e8240645f7b1f', '3785a4aebdd541f191f89a2f651f9677'),
    ('88a7bde4a4284d6cba2d203ab8113818', '5dd4cf43e7f04eeea35d3b3727b92ee1', '7e290cc71b9c46b49bbcf4f9f66be199'),
    ('8636bf7ffe8c48b78b8116c8fa092c4d', '5dd4cf43e7f04eeea35d3b3727b92ee1', '7e290cc71b9c46b49bbcf4f9f66be199');
