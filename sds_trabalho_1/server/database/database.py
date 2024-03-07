import psycopg2

class Database:
    def __init__(self, host, port, dbname, username, password):
        self.__host = host
        self.__port = port
        self.__dbname = dbname
        self.__username = username
        self.__password = password

        self.__connection = psycopg2.connect(
            dbname=self.__dbname,
            user=self.__username,
            password=self.__password,
            host=self.__host
        )
    
    def __str__(self):
        return super().__str__()
        