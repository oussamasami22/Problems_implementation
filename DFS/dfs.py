def dfs_iterative(graph, start):
    visited = set()  # Ensemble pour stocker les nœuds visités
    stack = [start]  # Utilisation d'une pile avec le nœud de départ

    while stack:  # Tant que la pile n'est pas vide
        node = stack.pop()  # Prendre le nœud en haut de la pile
        if node not in visited:
            visited.add(node)  # Marquer le nœud comme visité
            print(node)  # Traitement du nœud (ici, on l'affiche)

            # Ajouter les voisins non visités à la pile
            for neighbor in graph[node]:
                if neighbor not in visited:
                    stack.append(neighbor)

    return visited  # Retourner l'ensemble des nœuds visités

# Exemple d'utilisation :
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

# Démarrer DFS à partir du nœud 'A'
dfs_iterative(graph, 'A')
