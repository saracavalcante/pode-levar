# ADR 0002: Room as Source of Truth

## Status
Accepted

## Context
The app is offline-first; trips and packing lists must be usable
without network connectivity.

## Decision
Room is the single source of truth for Trip and PackingItem data.
UI observes local data via Flow. Remote weather data only updates
a local cache; it never becomes the primary data source.

## Consequences
- No feature can block on network availability to read/write core data.
- Weather failures must never prevent trip creation or checklist access.