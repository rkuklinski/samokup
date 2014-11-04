
use SpringSecurity;


INSERT INTO `Users` (`username`, `email`, `enabled`)
VALUES
    ('abc1ABC1', 'abc@abc.pl', 1);
INSERT INTO `UserPasswords` (`email`, `password`, `enabled`)
VALUES
    ('abc@abc.pl', '844a6fd100a2738091a6c791ff1a89f3b9399f6b', 1);
 
INSERT INTO `Roles` (`email`, `role`)
VALUES
    ('abc@abc.pl', 'Admin'),
    ('abc@abc.pl', 'CTO');

commit;