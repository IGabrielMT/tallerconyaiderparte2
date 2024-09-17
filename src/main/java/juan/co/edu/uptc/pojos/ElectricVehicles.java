package juan.co.edu.uptc.pojos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.ArrayList;


@ToString
public class ElectricVehicles {

    public static class Approval{
        public int reviewedAt;
        public boolean reviewedAutomatically;
        public String state;
        public int submissionId;
        public String submissionObject;
        public String submissionOutcome;
        public int submittedAt;
        public String targetAudience;
        public int workflowId;
        public SubmissionDetails submissionDetails;
        public SubmissionOutcomeApplication submissionOutcomeApplication;
        public Submitter submitter;
    }

    public static class ClientContext{
        public ArrayList<Object> clientContextVariables;
        public InheritedVariables inheritedVariables;
    }

    public static class Column{
        public int id;
        public String name;
        public String dataTypeName;
        public String fieldName;
        public int position;
        public String renderTypeName;
        public Format format;
        public ArrayList<String> flags;
        public String description;
        public int tableColumnId;
        public ComputationStrategy computationStrategy;
    }

    public static class ComputationStrategy{
        public ArrayList<String> source_columns;
        public String type;
        public Parameters parameters;
    }

    public static class CustomFields{
        @JsonProperty("Temporal")
        public Temporal temporal;
        @JsonProperty("Identification")
        public Identification identification;
        @JsonProperty("Notes")
        public Notes notes;
    }

    public static class Format{
        public String align;
    }

    public static class Grant{
        public boolean inherited;
        public String type;
        public ArrayList<String> flags;
    }

    public static class Identification{
        @JsonProperty("Originator")
        public String originator;
        @JsonProperty("Metadata Language")
        public String metadataLanguage;
    }

    public static class InheritedVariables{
    }

    public static class License{
        public String name;
        public String termsLink;
    }

    public class Meta{
        public View view;
    }

    public class Metadata{
        public CustomFields custom_fields;
        public String rowLabel;
        public ArrayList<String> availableDisplayTypes;
    }

    public static class Notes{
        @JsonProperty("1. ")
        public String one ;
        @JsonProperty("2. ")
        public String two;
        @JsonProperty("3. ")
        public String three; ;
        @JsonProperty("4. ")
        public String four;
    }

    public static class Owner{
        public String id;
        public String displayName;
        public String profileImageUrlLarge;
        public String profileImageUrlMedium;
        public String profileImageUrlSmall;
        public String screenName;
        public String type;
        public ArrayList<String> flags;
    }

    public static class Parameters{
        public String region;
        public String primary_key;
    }

    public static class Query{
    }

    public class Root2{
        public Meta meta;
        public ArrayList<ArrayList<Object>> data;
    }

    public static class SubmissionDetails{
        public String permissionType;
    }

    public static class SubmissionOutcomeApplication{
        public int failureCount;
        public String status;
    }

    public static class Submitter{
        public String id;
        public String displayName;
    }

    public static class TableAuthor{
        public String id;
        public String displayName;
        public String profileImageUrlLarge;
        public String profileImageUrlMedium;
        public String profileImageUrlSmall;
        public String screenName;
        public String type;
        public ArrayList<String> flags;
    }

    public static class Temporal{
        @JsonProperty("PostingFrequency")
        public String postingFrequency;
        @JsonProperty("Period of Time")
        public String periodOfTime;
    }

    public class View{
        public String id;
        public String name;
        public String assetType;
        public String attribution;
        public int averageRating;
        public String category;
        public int createdAt;
        public String description;
        public String displayType;
        public int downloadCount;
        public boolean hideFromCatalog;
        public boolean hideFromDataJson;
        public String licenseId;
        public boolean locked;
        public boolean newBackend;
        public int numberOfComments;
        public int oid;
        public String provenance;
        public boolean publicationAppendEnabled;
        public int publicationDate;
        public int publicationGroup;
        public String publicationStage;
        public int rowsUpdatedAt;
        public String rowsUpdatedBy;
        public int tableId;
        public int totalTimesRated;
        public int viewCount;
        public int viewLastModified;
        public String viewType;
        public ArrayList<Approval> approvals;
        public ClientContext clientContext;
        public ArrayList<Column> columns;
        public ArrayList<Grant> grants;
        public License license;
        public Metadata metadata;
        public Owner owner;
        public Query query;
        public ArrayList<String> rights;
        public TableAuthor tableAuthor;
        public ArrayList<String> tags;
        public ArrayList<String> flags;
    }
}
