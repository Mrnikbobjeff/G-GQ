# G-GQ: Building a naïve graph querying language

## 1.

TODO: Metamodel & Sirius editor

## 2. Refactoring & Repair

### Delete redundant edges

![Delete redundant edges](./assets/delete_redundant_edges_rule.png)

Observations:
- simple rule, similar to the exercise tasks

### Delete floating edges

![Delete floating edges](./assets/delete_floating_edges_rule.png)

Observations:
- `<<forbid>>` is new

### Resolve amibiguous IDs

![Resolve ambiguous IDs](./assets/resolve_ambiguous_ids_rule.png)

Observations:
- *OUT parameters* are new
- *Conditions* are new

## 3. Interpreter

We first implemented the naïve brute-force version propsed on the task sheet (see [cd1ea9ba](https://github.com/Mrnikbobjeff/G-GQ/commits/cd1ea9baaa6da81fdab6561bae629759cf680689)).
We've then refined it by filtering invalid matchings as soon as they break one of the queried edges.

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

## Résumé

We built a simple & naïve graph querying language.
It features a graphical editor, refactoring rules, a simplistic interpreter and interoparability with Henshin Transformations.
EMF allows to hide quite a lot of complexity under the hood, but is a rather hard-to-use tool itself.

