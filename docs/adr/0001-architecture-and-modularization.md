                                                                    # ADR 0001: Architecture and Modularization

## Status
Accepted

## Context
The project needs a layered architecture (UI/Domain/Data) with clear
dependency direction, per the product specification.

## Decision
- Layered architecture: UI depends on Domain; Data depends on Domain;
  Domain has no Android/Compose/Room dependencies.
- Start with minimal modules: :app, :core:model, :core:common,
  :core:designsystem. Additional core/feature modules are added only
  when a real shared need appears (no empty abstractions).

## Consequences
- core:model and core:common are pure Kotlin/JVM modules.
- core:designsystem is an Android library module (needs Compose UI).