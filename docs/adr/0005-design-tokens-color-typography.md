# ADR 0005: Design Tokens — Color, Spacing and Typography

## Status
Accepted

## Context
Section 27 of the spec lists final visual identity as a pending decision.
A working palette, spacing scale and typography are needed to build
screens consistently before that final brand decision is made.

Additionally, the app's core value proposition is offline-first
(sections 3.1, 7.5): the onboarding flow itself advertises a
"100% Offline" badge. Any design-system choice that introduces a
network or Google Play Services dependency for basic rendering would
contradict that identity.

## Decision

### Color
Color tokens use the Tailwind CSS default palette, matching the
provided design reference exactly: Primary = blue-800 (#1E40AF),
Secondary = sky-600 (#0284C7), Tertiary = emerald-500 (#10B981),
Neutral = slate-500 (#64748B). Full tonal scales (50–950) are derived
from Tailwind's published values.

Tokens are split into two layers, matching Material 3's own token
architecture (reference tokens → system tokens):
- `Palette.kt` (`internal` visibility) holds the raw tonal scale —
  reference tokens. Not accessible outside `:core:designsystem`.
- `Color.kt` maps those raw tones onto Material 3's semantic
  `ColorScheme` roles (primary, secondary, tertiary, surface, etc.) —
  system tokens. Screens only ever consume `MaterialTheme.colorScheme.*`,
  never a raw palette value directly.

### Spacing
Spacing follows a 4dp grid (`PodeLevarSpacing`: xs=4, sm=8, md=12,
lg=16, xl=24, xxl=32), per section 6.3.

### Typography
Typography uses Inter (open source, OFL license), bundled as font
resources in `core/designsystem/src/main/res/font/` and referenced via
Compose's `Font(R.font.*, weight)` API — not Android's Downloadable
Fonts.

Downloadable Fonts was considered and rejected for this project: it
fetches the font over network on first use through a Google Play
Services–backed provider, which is unavailable on devices/emulators
without Google APIs and would render with a fallback font until the
first successful fetch. That risk directly contradicts the app's
offline-first identity. Bundling trades a few KB of APK size for
guaranteed, connection-independent, consistent typography — the
correct trade-off for this product.

## Consequences
- Reference colors are a reversible assumption: if final brand colors
  differ from this baseline, only `Palette.kt`/`Color.kt` change — no
  screen or component needs to be touched, since all UI consumes theme
  roles, not literal colors.
- `Palette.kt` being `internal` is enforced by the Kotlin compiler, not
  just convention: code outside `:core:designsystem` cannot reference a
  raw tone directly, even by mistake.
- Font files are redistributed under the OFL license inside the
  repository; license terms must be re-verified if the typeface choice
  ever changes.
- Typography renders identically with or without network connectivity
  or Google Play Services present.