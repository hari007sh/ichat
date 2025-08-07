# Messenger

[![CI](https://github.com/your-org/messenger/actions/workflows/ci.yml/badge.svg)](https://github.com/your-org/messenger/actions/workflows/ci.yml)
[![Prod](https://github.com/your-org/messenger/actions/workflows/prod.yml/badge.svg)](https://github.com/your-org/messenger/actions/workflows/prod.yml)
[![Vuln Scan](https://img.shields.io/badge/vuln%20scan-passing-brightgreen)](https://github.com/your-org/messenger/security/code-scanning)
[![Coverage](https://img.shields.io/badge/coverage-90%25-brightgreen)](https://github.com/your-org/messenger/actions)

Ultra low-latency, end-to-end encrypted messenger targeting < 150 ms p99 at 1–2B MAU, built on Erlang/OTP, QUIC+MQTT, libsignal, and India-first integrations (UPI, Aadhaar eKYC, ONDC mini-programs).

## Quickstart

- make dev-up
- make seed
- make test-e2ee

See `docs/adr-001-architecture.md` and `SECURITY.md` for details.