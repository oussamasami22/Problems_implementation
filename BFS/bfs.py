from collections import deque

def bfs_shortest_path(n, graph, start):
    # Initialiser les distances avec -1 pour les nœuds inaccessibles
    distances = [-1] * (n + 1)
    
    # La distance de la source à elle-même est 0
    distances[start] = 0
    
    # Utiliser une file (queue) pour BFS
    queue = deque([start])
    
    while queue:
        node = queue.popleft()  # Retirer un nœud de la file
        current_distance = distances[node]
        
        # Parcourir les voisins du nœud courant
        for neighbor in graph[node]:
            if distances[neighbor] == -1:  # Si le voisin n'a pas encore été visité
                distances[neighbor] = current_distance + 1  # Mettre à jour la distance
                queue.append(neighbor)  # Ajouter le voisin dans la file
                
    # Retourner les distances pour tous les nœuds
    return distances[1:]

# Exemple d'utilisation
n = 6  # Nombre de nœuds
edges = [(1, 2), (1, 3), (3, 4), (2, 5), (5, 6)]  # Liste des arêtes
start = 1  # Nœud source

# Construire la liste d'adjacence
graph = {i: [] for i in range(1, n + 1)}
for u, v in edges:
    graph[u].append(v)
    graph[v].append(u)

# Calculer les distances les plus courtes depuis le nœud start
distances = bfs_shortest_path(n, graph, start)
print(distances)
