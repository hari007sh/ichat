# build stage
FROM ubuntu:22.04 as build
RUN apt-get update && apt-get install -y g++ cmake
WORKDIR /src
COPY . .
RUN echo '#include <iostream>\nint main(){ std::cout<<"media"; return 0; }' > main.cpp && \
    g++ -std=c++17 main.cpp -o app

# runtime
FROM gcr.io/distroless/cc
COPY --from=build /src/app /app
ENTRYPOINT ["/app"]