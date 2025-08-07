FROM hexpm/elixir:1.17.0-erlang-27.0-debian-bookworm-20240423 as build
WORKDIR /app
COPY . .
RUN mix local.hex --force && mix local.rebar --force && mix deps.get && MIX_ENV=prod mix release

FROM gcr.io/distroless/base-debian12
WORKDIR /app
COPY --from=build /app/_build/prod/rel/realtime .
ENV HOME=/app
USER 65532:65532
ENTRYPOINT ["/app/bin/realtime", "start"]