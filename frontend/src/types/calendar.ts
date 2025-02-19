import { Moment } from 'moment';

export interface CalendarEvent {
  id: number;
  title: string;
  startDate: Moment;
  endDate: Moment;
  allDay?: boolean;
  description?: string;
}

export interface CalendarEventModalProps {
  visible: boolean;
  selectedDate: Moment;
  selectedEvent?: CalendarEvent;
  onCancel: () => void;
  onDelete?: () => void;
  onSubmit: (
    title: string,
    description: string,
    isAllDay: boolean,
    start: Moment,
    end: Moment,
    shareCode?: string
  ) => void;
  onShare?: () => void;
  initialTitle?: string;
}

export interface CalendarViewProps {
  currentMonth: Moment;
  onPanelChange: (date: Moment) => void;
  selectedDate: Moment;
  onDateSelect: (date: Moment) => void;
  onEventSelect: (event: CalendarEvent) => void;
} 