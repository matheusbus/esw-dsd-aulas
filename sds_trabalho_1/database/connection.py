import psycopg2

# Parâmetros de conexão
driver = 'org.h2.Driver'
url = 'jdbc:h2:~/test'  # URL do banco de dados H2, neste caso, será um banco de dados em memória
user = 'sa'
password = ''

# Carregar o driver JDBC
conexao = psycopg2.connect(host='127.0.0.1', port='5432', dbname='matheus', user='postgres', password='postgres')

# Criar um cursor
cursor = conexao.cursor()

# Executar consultas
something = 'matheus'

cursor.execute('CREATE TABLE IF NOT EXISTS test(id INTEGER, name VARCHAR(255))')
cursor.execute('INSERT INTO test VALUES (1, \'TESTE\')')

# Recuperar os resultados
cursor.execute('SELECT * FROM test')
resultado = cursor.fetchall()
print(resultado)

# Fechar o cursor e a conexão
cursor.close()
conexao.close()
