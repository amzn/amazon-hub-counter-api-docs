# Amazon Hub Counter API Docs

This repository serves the documentation and the up-to-date OpenAPI spec of the Amazon Hub Counter API.

## What This API Does

The Amazon Hub Counter API (part of the Amazon Store Feed API) enables partners to programmatically create, update, and manage access points (e.g., pickup locations, counters) in Amazon's systems. It supports bulk operations for locations across North America, Europe, and Asia-Pacific regions.

- **Live Documentation**: [View the interactive API docs](https://amzn.github.io/amazon-hub-counter-api-docs/)
- **Key Features**: Authentication via OAuth, feed submission for location updates, asynchronous processing with status tracking.

## Local Development

To set up and run the documentation site locally:

### Prerequisites

- Ruby 2.7 or later (check with `ruby -v`)
- Bundler (install with `gem install bundler`)

### Setup Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/amzn/amazon-hub-counter-api-docs.git
   cd amazon-hub-counter-api-docs
   ```

2. Install dependencies:

   ```bash
   bundle install
   ```

3. Serve the site locally:

   ```bash
   bundle exec jekyll serve
   ```

4. Open your browser to `http://localhost:4000` to view the site.

### Building for Production

To build the static site:

```bash
bundle exec jekyll build
```

## Contributing

We welcome contributions! See [CONTRIBUTING.md](CONTRIBUTING.md) for detailed guidelines.

### Quick Start for Contributors

1. Fork the repository and create a feature branch.
2. Make your changes (e.g., update the OpenAPI spec or improve docs).
3. Test locally using the steps above.
4. Submit a pull request with a clear description.

For bug reports or feature requests, please open an issue

## License Summary

The documentation is made available under the Creative Commons Attribution-ShareAlike 4.0 International License. See the LICENSE file.

The sample code within this documentation is made available under the MIT-0 license. See the LICENSE-SAMPLECODE file.
