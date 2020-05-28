package bookreminder.bookreminder.api;

import bookreminder.bookreminder.domain.Report;
import bookreminder.bookreminder.repository.ReportRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportApiController {

    private final ReportRepository reportRepository;

    @GetMapping("/api/reports")
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @GetMapping("/api/reports/{id}")
    public Report getReport(@PathVariable("id") Long id) {
        return reportRepository.findOne(id);
    }

    @PostMapping("/api/reports")
    public CreateReportsResponse createReport(@RequestBody @Validated Report report) {
        reportRepository.save(report);
        return new CreateReportsResponse(report.getId());
    }

    @DeleteMapping("/api/reports/{id}")
    public CreateReportsResponse deleteReport(@PathVariable("id") Long id) {
        reportRepository.deleteOne(id);
        return new CreateReportsResponse(id);
    }

    @Data
    @AllArgsConstructor
    static class CreateReportsResponse {
        private Long id;
    }


}

