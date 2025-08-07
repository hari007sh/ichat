# ADR 001: Architecture Overview

- Status: Accepted
- Deciders: Platform, Realtime, Payments
- Date: 2025-08-07

## Context
Low-latency global messenger with India-first features, leveraging Erlang/OTP for realtime, QUIC+MQTT, libsignal for E2EE, and JVM/C++/Rust for hot paths.

## Decision
Adopt the monorepo layout described in the README and use the technologies pinned in the stack.

## Consequences
- Requires multi-language toolchain
- Enables horizontal scale with Scylla and stateless services

## References
- adr.github.io template