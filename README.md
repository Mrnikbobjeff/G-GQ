# G-GQ: Building a naïve graph querying language

## 1.

TODO: Metamodel & Sirius editor

## 2.

TODO: Refactoring rules

## 3. Interpreter

Intuition: Given a `host` and a `query` graph, generate all type-matching mappings between the vertices of `host` and the vertices of `query`.
Ensure queried edges are present in the `host` graph incrementally by checking once both sides are mapped.

```scala
generateMappings(
  EObject[] host,
  Vertex[] query,
  Edge[] edges
): { EObject => Vertex }[] {
  if (query == ∅) { // empty queries
    yield { }         // yield empty mappings
    return
  }
  
  queryVertex = head(query) // match the of the query
  for (hostVertex : host) { // with every possible host counterpart
    if (hostVertex ∉ queryVertex.type) {
      continue 
    }

    // if type matches: recursively generate mappings for remaining vertices
    otherPossibleMappings = generateMappings(host \ hostVertex, tail(query), edges)
    for (mapping : otherPossibleMappings) {
      extendedMapping = mapping ∪ { queryVertex => hostVertex }

      edgesConcernedByThisMapping = edges.filter(edge | edge.source == queryVertex || edge.target == queryVertex)
      someEdgeHasBeenMadeImpossible = edgesConcernedByThisMapping.hasSome(edge -> {
        mappedSource = extendedMapping[edge.source]
        mappedTarget = extendedMapping[edge.target]

        edgeIsFullyMapped = mappedSource != null && mappedTarget != null
        if (!edgeIsFullyMapped) {
          return false
        }

        edgeExistsInHost = target ∈ mappedSource.getReferencedTargets(edge.type)
        edgeHasBeenMadeImpossible = !edgeExistsInHost
        return edgeHasBeenMadeImpossible
      })

      if (!someEdgeHasBeenMadeImpossible) {
        yield extendedMapping
      }
    }
  }
}
```

## 4.

TODO: Henshin Transformation