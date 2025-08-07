defmodule Message.MixProject do
  use Mix.Project

  def project do
    [app: :message, version: "0.1.0", elixir: "~> 1.17", start_permanent: Mix.env() == :prod, deps: deps()]
  end

  def application do
    [extra_applications: [:logger]]
  end

  defp deps do
    [
      {:phoenix, "~> 1.7"},
      {:phoenix_live_view, "~> 0.20"},
      {:scylla, "~> 0.10"},
      {:vernemq_dev, "~> 1.12"},
      {:telemetry, "~> 1.2"}
    ]
  end
end