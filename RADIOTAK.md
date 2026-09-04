# RadioTAK exporters

This fork of [DSheirer/sdrtrunk](https://github.com/DSheirer/sdrtrunk) adds two isolated NDJSON exporters for [RadioTAK](https://github.com/CopIXus/RadioTAK):

| Class | Port | Payload |
| --- | --- | --- |
| `GeoEventJsonExporter` | 127.0.0.1:29500 | `sdr2tak.location.v1` GPS from `PlottableDecodeEvent` |
| `DftFrameExporter` | 127.0.0.1:29501 | 512-bin DFT frames for the Console waterfall |

Enable/disable via `SDRTrunk.properties`:

```
spectrum_export_enabled=true
spectrum_export_host=127.0.0.1
spectrum_export_port=29501
geo_event_export_enabled=true
geo_event_export_host=127.0.0.1
geo_event_export_port=29500
```

Tag `v0.6.2-radiotak.*` to publish `sdr-trunk-linux-aarch64-*.zip` from `.github/workflows/radiotak-release.yml`.
