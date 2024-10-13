def memoize(f):
    cache = {}
    
    def wrapped(*args):
        if args in cache:
            return cache[args]
        result = f(*args)
        cache[args] = result
        return result
    
    return wrapped

# Função de exemplo
@memoize
def fibonacci(n):
    if n < 2:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

# Testando a função com memoização
print(fibonacci(10))

# Saída esperada: 55
