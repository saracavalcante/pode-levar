# ADR 0004: String Resource Organization and Future English Support

## Status
Accepted

## Context
V1 ships only in pt-BR (spec section 1.1). English localization is a
planned future evolution, and the resource structure should avoid
requiring a large refactor when it happens.

## Decision
- All user-visible text lives in `strings.xml`/`plurals.xml` resources,
  never hardcoded in Kotlin or Composables.
- Each module (feature or app) owns its own `res/values/` resources.
  A string only moves to a shared module (e.g. a future `:core:ui`)
  when there is real, confirmed reuse across two or more features —
  never preemptively.
- Resource names are prefixed by owning domain (`app_*`, `onboarding_*`,
  etc.) and never depend on the Portuguese wording itself.
- Dynamic values use placeholders (`%1$d`, `%1$s`); quantities use
  `plurals`. No string concatenation for sentences.
- English support will be added later via `values-en/strings.xml`
  (and `values-en/plurals.xml`) mirroring the same resource names in
  each module that owns strings.

## Consequences
- Adding English later means creating `values-en/` files per module
  with the same keys — no restructuring of existing pt-BR resources.
- Until a second feature needs identical wording, near-duplicate
  strings (e.g. "Continuar" in different features) stay local to each
  module rather than being centralized speculatively.